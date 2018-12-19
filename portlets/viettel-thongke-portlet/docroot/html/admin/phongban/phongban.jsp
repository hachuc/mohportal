<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.viettel.portal.thongke.service.PhongBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.thongke.model.PhongBan"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="/html/admin/phongban/init.jsp"%>
<%
	String blank = "";
   
%>

<liferay-portlet:renderURL varImpl="phongBanAdminHomePageImplURL" var="">
	<liferay-portlet:param name="jspPage" value="/html/admin/phongban/view.jsp"/>
	<liferay-portlet:param name="phongBanSearchKeyword" value="<%=phongBanSearchKeyword %>"/>
</liferay-portlet:renderURL>

<div class="list-vl-phongban">
	<liferay-ui:search-container emptyResultsMessage="no-found-phongban"  iteratorURL="<%= phongBanAdminHomePageImplURL %>">
		<%
		    total = (int)PhongBanLocalServiceUtil.countPhongBans(scopeGroupId, phongBanSearchKeyword);
		    int end= searchContainer.getEnd()>total?total:searchContainer.getEnd();
			List<PhongBan> phongBans = PhongBanLocalServiceUtil.findPhongBans(scopeGroupId, phongBanSearchKeyword,  searchContainer.getStart(), end);
			int i=0;
		%>
		
		<liferay-ui:search-container-results results="<%=phongBans %>" total="<%=total %>"/>
		
		<liferay-ui:search-container-row className="com.viettel.portal.thongke.model.PhongBan" keyProperty="id" modelVar="phongBan" escapedModel="<%=true %>">
	
			<liferay-ui:search-container-column-text name="STT" orderable="<%=false %>"	>
			   <div style="text-align:  center;"><%=(searchContainer.getStart()+(++i)) %></div>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "ten-phongban") %>' value="<%= phongBan.getName()%>" 
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "created-date") %>' value="<%=phongBan.getCreateDate() != null ? dateTimeFormat.format(phongBan.getCreateDate()) : null%>"
				orderable="<%=false %>"
			/>
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "created-user") %>' value="<%= phongBan.getUserName()%>" 
				orderable="<%=false %>"
			/>			
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "edit") %>' align="center" cssClass="tbl_cell_action">
				<portlet:renderURL var="editPhongBanURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="jspPage" value="/html/admin/phongban/edit_phongban.jsp" />
					<portlet:param name="id" value="<%= String.valueOf(phongBan.getId()) %>" />
				</portlet:renderURL>
				
				<a href="javascript:;" onclick='updatePhongBanForm("<%=editPhongBanURL.toString() %>");'>
					<liferay-ui:icon image="edit"/>
				</a>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "delete") %>' align="center" cssClass="tbl_cell_action">
				<portlet:actionURL  name="deletePhongBan" var="deletePhongBanActionURL">
					<portlet:param name="id" value="<%=String.valueOf(phongBan.getId())%>"/>
					<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>   
					<portlet:param name="redirectURL" value='<%=adminHomePageURL%>'/>
				</portlet:actionURL>            
				<liferay-ui:icon-delete url="<%= deletePhongBanActionURL %>" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>