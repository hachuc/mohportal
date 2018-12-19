<%@page import="com.viettel.portal.thongke.service.PhongBanNhuanButLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.viettel.portal.thongke.model.PhongBanNhuanBut"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/admin/chamdiem/init.jsp" %>

<%
String keywords = ParamUtil.getString(request, "keywords","");
String fromDate = ParamUtil.getString(request, "fromDate","");
String toDate = ParamUtil.getString(request, "toDate","");
Date fDate=null,tDate=null;
if(!fromDate.equals("")){
	try{
		fDate=dateFormat.parse(fromDate);
	}
	catch(Exception ex){}
}
if(!toDate.equals("")){
	try{
		tDate=dateFormat.parse(toDate);
	}
	catch(Exception ex){}
}
System.out.println("menuId: "+menuId);
//System.out.println("keywords: "+keywords);
//System.out.println("fromDate: "+fromDate);
//System.out.println("toDate: "+toDate);
%>
<liferay-portlet:renderURL varImpl="chamDiemPhongBanAdminHomePageImplURL" var="">
    <liferay-portlet:param name="jspPage" value="/html/admin/chamdiem/view.jsp"/>
    <portlet:param name="menuId" value="<%=String.valueOf(menuId) %>"/>
</liferay-portlet:renderURL>

<div class="list-vl-phongban">
<liferay-ui:search-container emptyResultsMessage="no-found-chamdiemphongban"  iteratorURL="<%= chamDiemPhongBanAdminHomePageImplURL %>">
	<%
	    total = PhongBanNhuanButLocalServiceUtil.countPhongBanNhuanButs(scopeGroupId, keywords, fDate, tDate);
	    int end= searchContainer.getEnd()>total?total:searchContainer.getEnd();
		List<PhongBanNhuanBut> phongBans = PhongBanNhuanButLocalServiceUtil.findPhongBanNhuanButs(scopeGroupId, keywords, fDate, tDate, searchContainer.getStart(), end);
		int i=0;
	%>
	
	<liferay-ui:search-container-results results="<%=phongBans %>" total="<%=total %>"/>
	
	<liferay-ui:search-container-row className="com.viettel.portal.thongke.model.PhongBanNhuanBut" keyProperty="id" modelVar="phongBan" escapedModel="<%=true %>">

		<liferay-ui:search-container-column-text name="STT" orderable="<%=false %>"	>
		   <div style="text-align:  center;"><%=(searchContainer.getStart()+(++i)) %></div>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "tieu-de") %>' value="<%= phongBan.getCaption()%>" 
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "from-date") %>' value="<%=phongBan.getFromDate() != null ? dateTimeFormat.format(phongBan.getFromDate()) : null%>"
			orderable="<%=false %>"
		/>
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "to-date") %>' value="<%=phongBan.getToDate() != null ? dateTimeFormat.format(phongBan.getToDate()) : null%>" 
			orderable="<%=false %>"
		/>			
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "edit") %>' align="center" cssClass="tbl_cell_action">
			<portlet:renderURL var="editChamDiemPhongBanURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="jspPage" value="/html/admin/chamdiem/edit_chamdiemphongban.jsp" />
				<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
				<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
				<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>" />
				<portlet:param name="popup" value="1" />
				<portlet:param name="id" value="<%= String.valueOf(phongBan.getId()) %>" />
			</portlet:renderURL>
			<a href="javascript:;" onclick='updateChamDiemPhongBanForm("<%=editChamDiemPhongBanURL.toString() %>");'>
				<liferay-ui:icon image="edit"/>
			</a>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name='<%= LanguageUtil.get(locale, "delete") %>' align="center" cssClass="tbl_cell_action">
			<portlet:actionURL  name="deleteChamDiemPhongBan" var="deleteChamDiemPhongBanActionURL">
				<portlet:param name="id" value="<%=String.valueOf(phongBan.getId())%>"/>
				<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>   
				<portlet:param name="redirectURL" value='<%=PortalUtil.getCurrentURL(request) %>'/>
				<portlet:param name="menuId" value="<%=String.valueOf(menuId) %>" />
			</portlet:actionURL>            
			<liferay-ui:icon-delete url="<%= deleteChamDiemPhongBanActionURL %>" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</div>



