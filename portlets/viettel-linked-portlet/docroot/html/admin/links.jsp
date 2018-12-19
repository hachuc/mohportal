<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.viettel.portal.links.service.LCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.model.LCategory"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.viettel.portal.links.permission.VLinkPermission"%>
<%@page import="com.viettel.portal.links.service.VLinkLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.model.VLink"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.util.List"%>
<%@page import="com.viettel.portal.links.VLinkGrid"%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>
<%
	String blank = "";
%>
<liferay-portlet:renderURL varImpl="linkAdminHomePageImplURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="linkSearchKeyword" value="<%= linkSearchKeyword %>"/>
	<liferay-portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>"/>
</liferay-portlet:renderURL>

<div class="list-link">
	<liferay-ui:search-container emptyResultsMessage="no-found-link">
		<%
			VLinkGrid grid = VLinkLocalServiceUtil.findByKeyword(scopeGroupId, selectedCategoryId, linkSearchKeyword, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
			List<VLink> links = grid.getList();
			total = grid.getTotal();
		%>
		
		<liferay-ui:search-container-results results="<%=links %>" total="<%=total %>"/>
		
		<liferay-ui:search-container-row className="VLink" keyProperty="linkId" modelVar="ct" escapedModel="<%=true %>">
			<liferay-ui:search-container-column-text name="Tên-linkName" value="<%=ct.getLinkName()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Tên-url" value="<%= ct.getUrl() %>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Vị-trí" value="<%= blank + ct.getCorder() %>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Ngày-tạo" value="<%=dateTimeFormat.format(ct.getCreateDate())%>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="Người-tạo" value="<%= ct.getUserName()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
				<c:if test="<%=VLinkPermission.contains(permissionChecker, scopeGroupId, ActionKeys.UPDATE) %>">
					<portlet:renderURL var="editVLinkURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/edit_link.jsp" />
						<portlet:param name="id" value="<%= String.valueOf(ct.getLinkId()) %>" />
						<portlet:param name="categoryId" value="<%=String.valueOf(ct.getCategoryId())%>"/>   
					</portlet:renderURL>
					
					<a href="javascript:;" onclick='updateVLinkForm("<%=editVLinkURL.toString() %>");'>
						<liferay-ui:icon image="edit"/>
					</a>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
				<c:if test="<%=VLinkPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE) %>">
					<portlet:actionURL  name="deleteVLink" var="deleteVLinkActionURL">
						<portlet:param name="id" value="<%=String.valueOf(ct.getLinkId())%>"/>
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>  
						<portlet:param name="categoryId" value="<%=String.valueOf(ct.getCategoryId())%>"/>   
						<portlet:param name="redirectURL" value='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace()%>'/>
					</portlet:actionURL>            
					<liferay-ui:icon-delete url="<%= deleteVLinkActionURL %>" />
				</c:if>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>